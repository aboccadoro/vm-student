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
  def vendorParser: ProgramParser = new VendorProgramParser
  def byteCodeParser: ByteCodeParser = new MyByteCodeParser
  def virtualMachineParser: VirtualMachineParser = new ProgramParserAdapter
  def virtualMachine: VirtualMachine = new MyVirtualMachine
}
