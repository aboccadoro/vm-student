package bc

import vm.VirtualMachine

/**
*  Created by Anthony on 10/22/2015.
*/

/**
 * Each class represents a specific Byte mapped in [[bc.ByteCodeValues.bytecode]] and
 * is made via MyByteCodeFactory following the factory pattern. Each class has a code
 * value that represents the Byte value corresponding to the name of the instruction.
 * Each class has an execute function that executes the calculations given variables
 * from a virtual machine and then outputs the resulting virtual machine.
 */
class iconst(NUM: Int) extends ByteCode {
  val code: Byte = bytecode.apply(names.head)
  def execute(vm: VirtualMachine): VirtualMachine = vm.push(NUM)
}

class iadd extends ByteCode {
  val code: Byte = bytecode.apply(names(1))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 + y._1)
  }
}

class isub extends ByteCode {
  val code: Byte = bytecode.apply(names(2))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 - y._1)
  }
}

class imul extends ByteCode {
  val code: Byte = bytecode.apply(names(3))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 * y._1)
  }
}

class idiv extends ByteCode {
  val code: Byte = bytecode.apply(names(4))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 / y._1)
  }
}

class irem extends ByteCode {
  val code: Byte = bytecode.apply(names(5))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 % y._1)
  }
}

class ineg extends ByteCode {
  val code: Byte = bytecode.apply(names(6))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    x._2.push(-x._1)
  }
}

class iinc extends ByteCode {
  val code: Byte = bytecode.apply(names(7))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    x._2.push(x._1 + 1)
  }
}

class idec extends ByteCode {
  val code: Byte = bytecode.apply(names(8))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    x._2.push(x._1 - 1)
  }
}

class idup extends ByteCode {
  val code: Byte = bytecode.apply(names(9))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop();
    x._2.push(x._1).push(x._1)
  }
}

class iswap extends ByteCode {
  val code: Byte = bytecode.apply(names(10))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1).push(y._1)
  }
}

class print extends ByteCode {
  val code: Byte = bytecode.apply(names(11))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    println(x._1)
    x._2
  }
}
