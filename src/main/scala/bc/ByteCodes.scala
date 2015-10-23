package bc

import vm.VirtualMachine

/**
*  Created by Anthony on 10/22/2015.
*/
class iconst extends ByteCode {
  val code: Byte = names(0).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class iadd extends ByteCode {
  val code: Byte = names(1).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class isub extends ByteCode {
  val code: Byte = names(2).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class imul extends ByteCode {
  val code: Byte = names(3).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class idiv extends ByteCode {
  val code: Byte = names(4).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class irem extends ByteCode {
  val code: Byte = names(5).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class ineq extends ByteCode {
  val code: Byte = names(6).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class iinc extends ByteCode {
  val code: Byte = names(7).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class idec extends ByteCode {
  val code: Byte = names(8).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class idup extends ByteCode {
  val code: Byte = names(9).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class iswap extends ByteCode {
  val code: Byte = names(10).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}

class print extends ByteCode {
  val code: Byte = names(11).toByte
  def execute(vm: VirtualMachine): VirtualMachine = ???
  // TODO
}
