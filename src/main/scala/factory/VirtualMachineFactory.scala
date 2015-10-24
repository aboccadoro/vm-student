package factory

import adapter.ProgramParserAdapter
import bc._
import vendor.{ProgramParser, VendorProgramParser}
import vm._

/**
 * The `VirtualMachineFactory` follows the *factory pattern*. It provides
 * methods for each of the important parts in this assignment. You must
 * implement each method such that it returns an object of the correct type.
 */
object VirtualMachineFactory {
  def byteCodeFactory: ByteCodeFactory = MyByteCodeFactory
  // TODO
  def vendorParser: ProgramParser = new VendorProgramParser
  // TODO
  def byteCodeParser: ByteCodeParser = new MyByteCodeParser
  // TODO
  def virtualMachineParser: VirtualMachineParser = new ProgramParserAdapter
  // TODO
  def virtualMachine: VirtualMachine = new MyVirtualMachine
  // TODO
}
