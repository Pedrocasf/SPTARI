package VCS.MOS6507
import VCS.Config
import spinal.core._
import spinal.lib._

case class MOS6502(ADDR_WIDTH:Int) extends Component{
  assert(ADDR_WIDTH > 8)
  val io = new Bundle{
    val addrLow = out UInt(8 bits)
    val addr = out UInt(ADDR_WIDTH-8 bits)
    val data_in = in Bits(8 bits)
    val data_out = out Bits(8 bits)
    val rw = out Bool()
    val rdy = in Bool()
    val resn = in Bool()
    val irqn = in Bool()
    val nmin = in Bool()
  }
  val a = Reg(Bits(8 bits)) init 0
  val x = Reg(Bits(8 bits)) init 0
  val y = Reg(Bits(8 bits)) init 0
  val sp = Reg(UInt(8 bits)) init 0
  val pc = Reg(UInt(16 bits)) init 0
  val flags = Reg(Bits(8 bits)) init 0
}
object MOS6502 extends App{
  Config.spinal.generateVerilog(MOS6502(13))
}