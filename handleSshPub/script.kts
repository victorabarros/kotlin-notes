import java.util.Base64;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;


val pem: String = """MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqil7JAlBYw8sCG0OclCe94+16y18OtvtIp1oBoiFpzsr/fUXugXa51PHnbQOAyUFzWBKKzMqG00w13rf4d4zFNM888dAXGNaSKsXr5eRqGGtiwxC/MKNXDRb/p6zeCFDZ4wr44qy9uxxLp6PqCZy1AJcbPrrDMcgrPtJz5mj9RvIWAeOvxplhmR8l1X7PE9L0OKiC0icQSGRtJaH/1ZoFMugMWkrmP+5n5oEpRWQ4rYTibugvR7hunniOI9HlPBh5scpQ+eL/7vCyJJlNcGWSriyHrNHYhE1WR3gVda9SaeZuW+l3Zg/uPiJMVJIiCy1D49U+kIzXFyf/ezhwMilgwIDAQAB""".trimIndent();

val decoded: ByteArray = Base64.getDecoder().decode(pem);
val spec = X509EncodedKeySpec(decoded);
var kf: KeyFactory = KeyFactory.getInstance("RSA");
var pubKey: RSAPublicKey = kf.generatePublic(spec) as RSAPublicKey;

println(pubKey.modulus)
println(pubKey.getPublicExponent())
