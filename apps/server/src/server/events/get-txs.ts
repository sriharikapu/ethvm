import { txsPayloadValidator } from '@app/server/core/validation'
import { EthVMServer, SocketEvent, SocketEventValidationResult } from '@app/server/ethvm-server'
import { Tx } from 'ethvm-models'

const getTxsEvent: SocketEvent = {
  id: 'getTxs', // new_name: get-txs

  onValidate: (server: EthVMServer, socket: SocketIO.Socket, payload: any): SocketEventValidationResult => {
    const valid = txsPayloadValidator(payload) as boolean
    return {
      valid,
      errors: [] // TODO: Map properly the error
    }
  },

  onEvent: (server: EthVMServer, socket: SocketIO.Socket, payload: any): Promise<any[]> => server.txsService.getTxs(payload.limit, payload.page)
}

export default getTxsEvent
