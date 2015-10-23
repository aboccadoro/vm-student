package vendor

import bc.ByteCodeValues

/**
*  Created by Anthony on 10/22/2015.
*/
trait VendorProgramParser extends ProgramParser with ByteCodeValues {
  def parse(file: String): InstructionList = {
    val name = scala.io.Source.fromString(file)
    name.close()
    parseString(name.mkString)
    // TODO
  }
  def parseString(string: String): InstructionList = {
    val instructions: InstructionList = Vector[Instruction]()
    val order = string.split("\n")
    for (s <- order) {
      if (!names.contains(s)) throw new InvalidInstructionFormatException("not a valid instruction input")
      if (s.split(" ")(0).equals("iconst")) instructions :+ new Instruction(s, Vector[Int](s.split(" ")(1).toInt))
      else instructions :+ new Instruction(s, Vector[Int]())
    }
    instructions
    // TODO
  }
}
