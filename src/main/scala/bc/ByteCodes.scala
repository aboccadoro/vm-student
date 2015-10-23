package bc

import vm.VirtualMachine

/**
*  Created by Anthony on 10/22/2015.
*/
class iconst(NUM: Int) extends ByteCode {
  val code: Byte = names(0).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(NUM)
  // TODO
}

class iadd extends ByteCode {
  val code: Byte = names(1).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop() + vm.pop())
  // TODO

class isub extends ByteCode {
  val code: Byte = names(2).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop() - vm.pop())
  // TODO
}

class imul extends ByteCode {
  val code: Byte = names(3).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop() * vm.pop())
  // TODO
}

class idiv extends ByteCode {
  val code: Byte = names(4).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop() / vm.pop())
  // TODO
}

class irem extends ByteCode {
  val code: Byte = names(5).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop() % vm.pop())
  // TODO
}

class ineg extends ByteCode {
  val code: Byte = names(6).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(-vm.pop())
  // TODO
}

class iinc extends ByteCode {
  val code: Byte = names(7).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop() + 1)
  // TODO
}

class idec extends ByteCode {
  val code: Byte = names(8).toByte
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop() - 1)
}

class idup extends ByteCode {
  val code: Byte = names(9).toByte
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop(); vm.push(x); vm.push(x)
    // TODO
}

class iswap extends ByteCode {
  val code: Byte = names(10).toByte
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop(); val y = vm.pop(); vm.push(x); vm.push(y)
    // TODO
  }
}

class print extends ByteCode {
  val code: Byte = names(11).toByte
  def execute(vm: VirtualMachine): VirtualMachine = {
    println(vm.pop())
    vm
    // TODO
  }
}
