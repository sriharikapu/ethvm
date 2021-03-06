package io.enkrypt.bolt

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import io.enkrypt.bolt.Modules.kafkaModule
import io.enkrypt.bolt.Modules.mongoModule
import io.enkrypt.bolt.Modules.processorsModule
import io.enkrypt.bolt.processors.*
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin

class Cli : CliktCommand() {

  // General - CLI
  private val bootstrapServers: String by option(
    help = "A list of host/port pairs to use for establishing the initial connection to the Kafka cluster",
    envvar = "KAFKA_BOOTSTRAP_SERVERS"
  ).default(DEFAULT_BOOTSTRAP_SERVERS)

  private val startingOffset: String by option(
    help = "From which offset is going to start Bolt processing events",
    envvar = "KAFKA_START_OFFSET"
  ).default(DEFAULT_AUTO_OFFSET)

  private val resetStreamsState: Int by option(
    help = "Whether or not to reset local persisted streams processing state",
    envvar = "KAFKA_STREAMS_RESET"
  ).int().default(DEFAULT_STREAMS_RESET)

  // Input Topics - CLI
  private val blocksTopic: String by option(
    help = "Name of the blocks stream topic on which Bolt will listen",
    envvar = "KAFKA_BLOCKS_TOPIC"
  ).default(DEFAULT_BLOCKS_TOPIC)

  private val pendingTxsTopic: String by option(
    help = "Name of the pending transactions topic on which Bolt will listen",
    envvar = "KAFKA_PENDING_TXS_TOPIC"
  ).default(DEFAULT_PENDING_TXS_TOPIC)

  private val accountStateTopic: String by option(
    help = "Name of the account state topic on which Bolt will listen",
    envvar = "KAFKA_ACCOUNT_STATE_TOPIC"
  ).default(DEFAULT_ACCOUNT_STATE_TOPIC)

  private val metadataTopic: String by option(
    help = "Name of the metadata topic on which Bolt will listen",
    envvar = "KAFKA_METADATA_TOPIC"
  ).default(DEFAULT_METADATA_TOPIC)

  // Mongo - CLI
  private val mongoUri: String by option(
    help = "Mongo URI",
    envvar = "MONGO_URI"
  ).default(DEFAULT_MONGO_URI)

  // DI

  private val configModule = module {

    single {

      MongoConfig(
        mongoUri,
        "accounts",
        "blocks",
        "pending_transactions",
        "statistics"
      )

    }

    single {
      KafkaConfig(
        bootstrapServers,
        startingOffset,
        KafkaTopicsConfig(
          blocksTopic,
          pendingTxsTopic,
          accountStateTopic,
          metadataTopic
        ))
    }

    single { AppConfig(get(), get()) }

  }

  override fun run() {

    startKoin(listOf(configModule, mongoModule, kafkaModule, processorsModule))

    listOf<Processor>(
      BlocksProcessor(),
      ChartsProcessor(),
      AccountStateProcessor(),
      PendingTransactionsProcessor()
    ).forEach {
      it.onPrepareProcessor()
      it.start(resetStreamsState == 1)
    }
  }

  companion object Defaults {

    const val DEFAULT_BOOTSTRAP_SERVERS = "localhost:9092"
    const val DEFAULT_AUTO_OFFSET = "earliest"
    const val DEFAULT_STREAMS_RESET = 0

    const val DEFAULT_MONGO_URI = "mongodb://localhost:27017/ethvm_local"

    const val DEFAULT_BLOCKS_TOPIC = "blocks"
    const val DEFAULT_PENDING_TXS_TOPIC = "pending-transactions"
    const val DEFAULT_ACCOUNT_STATE_TOPIC = "account-state"
    const val DEFAULT_METADATA_TOPIC = "account-state"
  }
}
