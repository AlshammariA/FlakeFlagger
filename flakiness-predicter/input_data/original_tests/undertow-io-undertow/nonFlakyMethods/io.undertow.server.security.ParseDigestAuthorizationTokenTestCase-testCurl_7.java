@Test public void testCurl_7(){
  final String header="username=\"userTwo\", realm=\"Digest_Realm\", nonce=\"5CgZ39vhie0NMTM1MTUyNDc4ODkwNMwr6sWKVSGfhXB4jBtkupY=\", uri=\"/\", cnonce=\"MTYwOTQ4\", nc=00000001, qop=\"auth\", response=\"c3c1ce9945a0c36d54860eda7846018b\", opaque=\"00000000000000000000000000000000\", algorithm=\"MD5\"";
  Map<DigestAuthorizationToken,String> expected=new HashMap<DigestAuthorizationToken,String>(10);
  expected.put(DigestAuthorizationToken.USERNAME,"userTwo");
  expected.put(DigestAuthorizationToken.REALM,"Digest_Realm");
  expected.put(DigestAuthorizationToken.NONCE,"5CgZ39vhie0NMTM1MTUyNDc4ODkwNMwr6sWKVSGfhXB4jBtkupY=");
  expected.put(DigestAuthorizationToken.DIGEST_URI,"/");
  expected.put(DigestAuthorizationToken.CNONCE,"MTYwOTQ4");
  expected.put(DigestAuthorizationToken.NONCE_COUNT,"00000001");
  expected.put(DigestAuthorizationToken.MESSAGE_QOP,DigestQop.AUTH.getToken());
  expected.put(DigestAuthorizationToken.RESPONSE,"c3c1ce9945a0c36d54860eda7846018b");
  expected.put(DigestAuthorizationToken.OPAQUE,"00000000000000000000000000000000");
  expected.put(DigestAuthorizationToken.ALGORITHM,DigestAlgorithm.MD5.getToken());
  doTest(header,expected);
}
