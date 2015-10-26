package vm

import bc.{ByteCodeValues, ByteCode}

/**
*  Created by Anthony on 10/22/2015.
*/
class MyVirtualMachine extends VirtualMachine with ByteCodeValues {
  var stack = Vector[Int]()
  def execute(bc: Vector[ByteCode]): VirtualMachine = {
    for (code <- bc) code.execute(this)
    this
    // TODO
  }
  def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
    (bc.drop(1), bc.head.execute(this))
    // TODO
  }
  def push(value: Int): VirtualMachine = {
    stack = stack.+:(value)
    this
    // TODO
  }
  def pop(): (Int, VirtualMachine) = {
    if (stack.isEmpty) throw new MachineUnderflowException("no more elements left to pop()")
    val value = stack.head
    stack = stack.drop(1)
    (value, this)
    // TODO
  }
  def state: Vector[Int] = stack
  // TODO
}
