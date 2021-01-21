/** 
 * Test that a request is correctly rejected with a bad user name. In this case both the supplied username is wrong and also the generated response can not be valid as there is no corresponding user.
 */
@Test public void testBadUserName() throws Exception {
  setAuthenticationChain();
  TestHttpClient client=new TestHttpClient();
  HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL());
  HttpResponse result=client.execute(get);
  assertEquals(401,result.getStatusLine().getStatusCode());
  Header[] values=result.getHeaders(WWW_AUTHENTICATE.toString());
  assertEquals(1,values.length);
  String value=values[0].getValue();
  assertTrue(value.startsWith(DIGEST.toString()));
  Map<DigestWWWAuthenticateToken,String> parsedHeader=DigestWWWAuthenticateToken.parseHeader(value.substring(7));
  assertEquals(REALM_NAME,parsedHeader.get(DigestWWWAuthenticateToken.REALM));
  assertEquals(DigestAlgorithm.MD5.getToken(),parsedHeader.get(DigestWWWAuthenticateToken.ALGORITHM));
  String nonce=parsedHeader.get(DigestWWWAuthenticateToken.NONCE);
  String response=createResponse("badUser",REALM_NAME,"passwordOne","GET","/",nonce);
  client=new TestHttpClient();
  get=new HttpGet(DefaultServer.getDefaultServerURL());
  StringBuilder sb=new StringBuilder(DIGEST.toString());
  sb.append(" ");
  sb.append(DigestAuthorizationToken.USERNAME.getName()).append("=").append("\"badUser\"").append(",");
  sb.append(DigestAuthorizationToken.REALM.getName()).append("=\"").append(REALM_NAME).append("\",");
  sb.append(DigestAuthorizationToken.NONCE.getName()).append("=\"").append(nonce).append("\",");
  sb.append(DigestAuthorizationToken.DIGEST_URI.getName()).append("=\"/\",");
  sb.append(DigestAuthorizationToken.RESPONSE.getName()).append("=\"").append(response).append("\"");
  get.addHeader(AUTHORIZATION.toString(),sb.toString());
  result=client.execute(get);
  assertEquals(401,result.getStatusLine().getStatusCode());
  assertSingleNotificationType(EventType.FAILED_AUTHENTICATION);
}
