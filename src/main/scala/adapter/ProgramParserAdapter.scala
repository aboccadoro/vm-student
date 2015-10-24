package adapter

import bc.{MyByteCodeParser, ByteCode}
import vendor.{Instruction, VendorProgramParser}
import vm.VirtualMachineParser

/**
*  Created by Anthony on 10/22/2015.
*/
class ProgramParserAdapter extends VirtualMachineParser {
  val vpParser = new VendorProgramParser
  val bcParser = new MyByteCodeParser
  def parse(file: String): Vector[ByteCode] = {
    val instructions: Vector[Instruction] = vpParser.parse(file)
    var string = ""
    for (instruction <- instructions) {
      string += instruction.toString + " "
    }
    parseString(string)
    // TODO
  }
  def parseString(str: String): Vector[ByteCode] = {
    val bytes = Vector[Byte]()
    val instructions = str.split(" ")
    for(instruction <- instructions) {
      bytes :+ instruction.toByte
    }
    bcParser.parse(bytes)
    // TODO
  }
}
