package bc

import vm.VirtualMachine

/**
*  Created by Anthony on 10/22/2015.
*/
trait ByteCodes extends ByteCode{
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}
