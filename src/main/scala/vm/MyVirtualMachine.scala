package vm

import bc.ByteCode

/**
*  Created by Anthony on 10/22/2015.
*/
class MyVirtualMachine extends VirtualMachine {
  val stack = Vector[Int]()
  def execute(bc: Vector[ByteCode]): VirtualMachine = ???
  // TODO
  def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = ???
  // TODO
  def push(value: Int): VirtualMachine = {
    stack :+ value
    this
    // TODO
  }
  def pop(): (Int, VirtualMachine) = {
    if (stack.isEmpty) throw new MachineUnderflowException("no more elements left to pop()")
    val value = stack(0)
    stack.drop(1)
    (value, this)
    // TODO
  }
  def state: Vector[Int] = stack
  // TODO
}
