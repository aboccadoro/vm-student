package vendor

import bc.{InvalidBytecodeException, ByteCodeValues}

/**
*  Created by Anthony on 10/22/2015.
*/

/**
 * The VendorProgramParser parses a file line by line to Instruction objects
 * where they are stored in an InstructionList.
 */
class VendorProgramParser extends ProgramParser with ByteCodeValues {
  def parse(file: String): InstructionList = {
    val name = scala.io.Source.fromFile(file)
    parseString(name.mkString)
  }
  def parseString(string: String): InstructionList = {
    var instructions: InstructionList = Vector[Instruction]()
    val order = string.split("\n")
    for (s <- order) {
      if (!names.contains(s.split(" ").head)) throw new InvalidBytecodeException(s + " not a valid ByteCode")
      else if (s.split(" ").head.equals("iconst")) instructions = instructions :+ new Instruction(s.split(" ").head, Vector[Int](s.split(" ").last.toInt))
      else if (names.contains(s)) instructions = instructions :+ new Instruction(s, Vector[Int]())
    }
    instructions
  }
}
