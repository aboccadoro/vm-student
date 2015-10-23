package bc

/**
*  Created by Anthony on 10/22/2015.
*/
object MyByteCodeFactory extends ByteCodeFactory with ByteCodeValues {
  def make(byte: Byte, args: Int*): ByteCode = {
    if (byte.equals(bytecode.apply("iconst"))) new iconst((for(arg <- args) yield arg).head)
    else {
      if (byte.equals(bytecode.apply("iadd"))) new iadd
      else if (byte.equals(bytecode.apply("isub"))) new isub
      else if (byte.equals(bytecode.apply("imul"))) new imul
      else if (byte.equals(bytecode.apply("idiv"))) new idiv
      else if (byte.equals(bytecode.apply("irem"))) new irem
      else if (byte.equals(bytecode.apply("ineg"))) new ineg
      else if (byte.equals(bytecode.apply("iinc"))) new iinc
      else if (byte.equals(bytecode.apply("idec"))) new idec
      else if (byte.equals(bytecode.apply("idup"))) new idup
      else if (byte.equals(bytecode.apply("iswap"))) new iswap
      else if (byte.equals(bytecode.apply("print"))) new print
      else throw new InvalidBytecodeException("not a valid bytecode")
    }
    // TODO
  }
}
