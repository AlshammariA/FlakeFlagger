@Test public void testChrome_22(){
  final String header="username=\"userTwo\", realm=\"Digest_Realm\", nonce=\"Yxmkh5liIOYNMTM1MTUyNjQzMTE4NJziT7YLEOEJ4QEN1py4Yog=\", uri=\"/\", algorithm=MD5, response=\"5b26e00233607e8a714cd1d910692e08\", opaque=\"00000000000000000000000000000000\", qop=auth, nc=00000001, cnonce=\"8c008c8ce43dc0a7\"";
  Map<DigestAuthorizationToken,String> expected=new HashMap<DigestAuthorizationToken,String>(10);
  expected.put(DigestAuthorizationToken.USERNAME,"userTwo");
  expected.put(DigestAuthorizationToken.REALM,"Digest_Realm");
  expected.put(DigestAuthorizationToken.NONCE,"Yxmkh5liIOYNMTM1MTUyNjQzMTE4NJziT7YLEOEJ4QEN1py4Yog=");
  expected.put(DigestAuthorizationToken.DIGEST_URI,"/");
  expected.put(DigestAuthorizationToken.ALGORITHM,DigestAlgorithm.MD5.getToken());
  expected.put(DigestAuthorizationToken.RESPONSE,"5b26e00233607e8a714cd1d910692e08");
  expected.put(DigestAuthorizationToken.OPAQUE,"00000000000000000000000000000000");
  expected.put(DigestAuthorizationToken.MESSAGE_QOP,DigestQop.AUTH.getToken());
  expected.put(DigestAuthorizationToken.NONCE_COUNT,"00000001");
  expected.put(DigestAuthorizationToken.CNONCE,"8c008c8ce43dc0a7");
  doTest(header,expected);
}
