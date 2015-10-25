package adapter

import bc.{ByteCodeValues, MyByteCodeParser, ByteCode}
import vendor.VendorProgramParser
import vm.VirtualMachineParser

/**
*  Created by Anthony on 10/22/2015.
*/
class ProgramParserAdapter extends VirtualMachineParser with ByteCodeValues {
  val vpParser = new VendorProgramParser
  val bcParser = new MyByteCodeParser
  def parse(file: String): Vector[ByteCode] = {
    val instructions = vpParser.parse(file)
    var string = ""
    for (instruction <- instructions) string += instruction.toString + " "
    parseString(string)
    // TODO
  }
  def parseString(str: String): Vector[ByteCode] = {
    var bytes = Vector[Byte]()
    val instructions = str.split(" +")
    for(instruction <- instructions) {
      if (bytecode.contains(instruction)) bytes = bytes :+ bytecode.apply(instruction)
      else bytes = bytes :+ instruction.toByte
    }
    bcParser.parse(bytes)
    // TODO
  }
}
