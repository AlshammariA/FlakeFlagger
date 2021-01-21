@Test public void testOpera_12(){
  final String header="username=\"userOne\", realm=\"Digest_Realm\", uri=\"/\", algorithm=MD5, nonce=\"D2floAc+FhkNMTM1MTUyMzY2ODc4Mhbi2Zrcuv1lvdgEaPXa+bg=\", cnonce=\"v722VYJEeG28C3SoXS8BEWThGHPDOlXgUCCts70i7Fc=\", opaque=\"00000000000000000000000000000000\", qop=auth, nc=00000001, response=\"8106a5d19bc67982527cbb576658f9d6\"";
  Map<DigestAuthorizationToken,String> expected=new HashMap<DigestAuthorizationToken,String>(10);
  expected.put(DigestAuthorizationToken.USERNAME,"userOne");
  expected.put(DigestAuthorizationToken.REALM,"Digest_Realm");
  expected.put(DigestAuthorizationToken.DIGEST_URI,"/");
  expected.put(DigestAuthorizationToken.ALGORITHM,DigestAlgorithm.MD5.getToken());
  expected.put(DigestAuthorizationToken.NONCE,"D2floAc+FhkNMTM1MTUyMzY2ODc4Mhbi2Zrcuv1lvdgEaPXa+bg=");
  expected.put(DigestAuthorizationToken.CNONCE,"v722VYJEeG28C3SoXS8BEWThGHPDOlXgUCCts70i7Fc=");
  expected.put(DigestAuthorizationToken.OPAQUE,"00000000000000000000000000000000");
  expected.put(DigestAuthorizationToken.MESSAGE_QOP,DigestQop.AUTH.getToken());
  expected.put(DigestAuthorizationToken.NONCE_COUNT,"00000001");
  expected.put(DigestAuthorizationToken.RESPONSE,"8106a5d19bc67982527cbb576658f9d6");
  doTest(header,expected);
}
