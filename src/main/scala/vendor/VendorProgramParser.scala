package vendor

import bc.ByteCodeValues

/**
*  Created by Anthony on 10/22/2015.
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
      if (!names.contains(s.split(" ").head) && !Character.isDigit(s.last)) throw new InvalidInstructionFormatException(s + " not a valid instruction input")
      else if (s.split(" ").head.equals("iconst")) instructions = instructions :+ new Instruction(s.split(" ").head, Vector[Int](s.split(" ").last.toInt))
      else if (names.contains(s)) instructions = instructions :+ new Instruction(s, Vector[Int]())
    }
    instructions
  }
}
