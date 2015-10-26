package adapter

import bc.{ByteCodeValues, MyByteCodeParser, ByteCode}
import vendor.VendorProgramParser
import vm.VirtualMachineParser

/**
*  Created by Anthony on 10/22/2015.
*/
class ProgramParserAdapter extends VirtualMachineParser with ByteCodeValues {
  def parse(file: String): Vector[ByteCode] = {
    val vpParser = new VendorProgramParser
    val bcParser = new MyByteCodeParser
    var bytes = Vector[Byte]()
    val instructions = vpParser.parse(file)
    var string = ""
    for (instruction <- instructions) string += instruction.toString + " "
    for(instruction <- string.split(" +")) {
      if (bytecode.contains(instruction)) bytes = bytes :+ bytecode.apply(instruction)
      else bytes = bytes :+ instruction.toByte
    }
    bcParser.parse(bytes)
    // TODO
  }
  def parseString(str: String): Vector[ByteCode] = {
    val bcParser = new MyByteCodeParser
    var bytes = Vector[Byte]()
    val instructions = str.split("\n")
    for(instruction <- instructions) {
      if (instruction.split(" ").head.equals("iconst")) {
        bytes = bytes :+ bytecode.apply(instruction.split(" ").head)
        bytes = bytes :+ instruction.split(" ").last.toByte
      }
      else bytes = bytes :+ bytecode.apply(instruction)
    }
    bcParser.parse(bytes)
    // TODO
  }
}
