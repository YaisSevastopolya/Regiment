import java.io.DataOutputStream
import java.io.IOException
import java.net.ServerSocket

object SocketServer {
    const val SERVER_PORT = 50001
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            val server = ServerSocket(SERVER_PORT)
            val clientConn = server.accept()
            val serverOutput = DataOutputStream(clientConn.getOutputStream())
            serverOutput.writeBytes("Java revisited\n")
            clientConn.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}