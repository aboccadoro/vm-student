package bc

import vendor.InvalidInstructionFormatException

/**
*  Created by Anthony on 10/22/2015.
*/

/**
 * MyByteCodeFactory uses the Factory pattern to make a ByteCode object
 * based on the Byte definition and  Int argument for the iconst Byte.
 * An exception is thrown if an invalid byte is passed or there are too
 * many iconst integers assigned to one iconst object.
 */
object MyByteCodeFactory extends ByteCodeFactory with ByteCodeValues {
  def make(byte: Byte, args: Int*): ByteCode = {
    if (args.size > 1) throw new InvalidInstructionFormatException("too many arguments received")
    var count = 0
    for((name, code) <- bytecode) if (code != byte) count += 1
    if (count == bytecode.size) throw new InvalidBytecodeException("[" + byte + "]" + " is not a supported byte")
    else if (bytecode.apply("iconst").equals(byte)) new iconst(args.head)
    else cases(byte)
  }

  def cases(byte: Byte): ByteCode = byte match {
    case 2 => new iadd()
    case 3 => new isub()
    case 4 => new imul()
    case 5 => new idiv()
    case 6 => new irem()
    case 7 => new ineg()
    case 8 => new iinc()
    case 9 => new idec()
    case 10 => new idup()
    case 11 => new iswap()
    case 12 => new print()
  }
}
