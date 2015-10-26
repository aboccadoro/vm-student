package vm

import bc.{ByteCodeValues, ByteCode}

/**
*  Created by Anthony on 10/22/2015.
*/

/**
 * MyVirtualMachine represents a virtual machine that executes a stack
 * of commands defined by a list of instructions where a command name is
 * represented with a Byte value.
 */
class MyVirtualMachine extends VirtualMachine with ByteCodeValues {
  var stack = Vector[Int]()
  def execute(bc: Vector[ByteCode]): VirtualMachine = {
    for (code <- bc) code.execute(this)
    this
  }
  def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
    (bc.drop(1), bc.head.execute(this))
  }
  def push(value: Int): VirtualMachine = {
    stack = stack.+:(value)
    this
  }
  def pop(): (Int, VirtualMachine) = {
    if (stack.isEmpty) throw new MachineUnderflowException("no more elements left to pop()")
    val value = stack.head
    stack = stack.drop(1)
    (value, this)
  }
  def state: Vector[Int] = stack
}
