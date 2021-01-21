@Test public void testFirefox_16(){
  final String header="username=\"userOne\", realm=\"Digest_Realm\", nonce=\"nBhFxtSS6rkNMTM1MTUyNjE2MjgyNWA/xW/LOH53vhXGq/2B/yQ=\", uri=\"/\", algorithm=MD5, response=\"b0adb1025da2de0d16f44131858bad6f\", opaque=\"00000000000000000000000000000000\", qop=auth, nc=00000001, cnonce=\"8127726535363b07\"";
  Map<DigestAuthorizationToken,String> expected=new HashMap<DigestAuthorizationToken,String>(10);
  expected.put(DigestAuthorizationToken.USERNAME,"userOne");
  expected.put(DigestAuthorizationToken.REALM,"Digest_Realm");
  expected.put(DigestAuthorizationToken.NONCE,"nBhFxtSS6rkNMTM1MTUyNjE2MjgyNWA/xW/LOH53vhXGq/2B/yQ=");
  expected.put(DigestAuthorizationToken.DIGEST_URI,"/");
  expected.put(DigestAuthorizationToken.ALGORITHM,DigestAlgorithm.MD5.getToken());
  expected.put(DigestAuthorizationToken.RESPONSE,"b0adb1025da2de0d16f44131858bad6f");
  expected.put(DigestAuthorizationToken.OPAQUE,"00000000000000000000000000000000");
  expected.put(DigestAuthorizationToken.MESSAGE_QOP,DigestQop.AUTH.getToken());
  expected.put(DigestAuthorizationToken.NONCE_COUNT,"00000001");
  expected.put(DigestAuthorizationToken.CNONCE,"8127726535363b07");
  doTest(header,expected);
}
