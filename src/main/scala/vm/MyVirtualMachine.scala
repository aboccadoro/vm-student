package vm

import bc.ByteCode

/**
*  Created by Anthony on 10/22/2015.
*/
trait MyVirtualMachine extends VirtualMachine{
  def execute(bc: Vector[ByteCode]): VirtualMachine = ???
  // TODO
  def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = ???
  // TODO
  def push(value: Int): VirtualMachine = ???
  // TODO
  def pop(): (Int, VirtualMachine) = ???
  // TODO
  def state: Vector[Int] = ???
  // TODO
}
