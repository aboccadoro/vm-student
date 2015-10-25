package bc

import vm.VirtualMachine

/**
*  Created by Anthony on 10/22/2015.
*/


class iconst(NUM: Int) extends ByteCode {
  val code: Byte = bytecode.apply(names.head)
  def execute(vm: VirtualMachine): VirtualMachine = {
    println("made it")
    vm.push(NUM)
  }
  // TODO
}

class iadd extends ByteCode {
  val code: Byte = bytecode.apply(names(1))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 + y._1)
  }
  // TODO
}

class isub extends ByteCode {
  val code: Byte = bytecode.apply(names(2))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 - y._1)
  }
  // TODO
}

class imul extends ByteCode {
  val code: Byte = bytecode.apply(names(3))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 * y._1)
  }
  // TODO
}

class idiv extends ByteCode {
  val code: Byte = bytecode.apply(names(4))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 / y._1)
  }
  // TODO
}

class irem extends ByteCode {
  val code: Byte = bytecode.apply(names(5))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1 % y._1)
  }
  // TODO
}

class ineg extends ByteCode {
  val code: Byte = bytecode.apply(names(6))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    x._2.push(-x._1)
  }
  // TODO
}

class iinc extends ByteCode {
  val code: Byte = bytecode.apply(names(7))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    x._2.push(x._1 + 1)
  }
  // TODO
}

class idec extends ByteCode {
  val code: Byte = bytecode.apply(names(8))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    x._2.push(x._1 - 1)
  }
  // TODO
}

class idup extends ByteCode {
  val code: Byte = bytecode.apply(names(9))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop();
    x._2.push(x._1).push(x._1)
    // TODO
  }
}

class iswap extends ByteCode {
  val code: Byte = bytecode.apply(names(10))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    val y = x._2.pop()
    y._2.push(x._1).push(y._1)
    // TODO
  }
}

class print extends ByteCode {
  val code: Byte = bytecode.apply(names(11))
  def execute(vm: VirtualMachine): VirtualMachine = {
    val x = vm.pop()
    println(x._1)
    x._2.push(x._1)
    // TODO
  }
}
