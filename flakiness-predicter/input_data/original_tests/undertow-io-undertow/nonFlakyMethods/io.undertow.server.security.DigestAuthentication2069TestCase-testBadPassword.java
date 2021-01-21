/** 
 * Test that a request is correctly rejected if a bad password is used to generate the response value.
 */
@Test public void testBadPassword() throws Exception {
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
  String response=createResponse("userOne",REALM_NAME,"badPassword","GET","/",nonce);
  client=new TestHttpClient();
  get=new HttpGet(DefaultServer.getDefaultServerURL());
  StringBuilder sb=new StringBuilder(DIGEST.toString());
  sb.append(" ");
  sb.append(DigestAuthorizationToken.USERNAME.getName()).append("=").append("\"userOne\"").append(",");
  sb.append(DigestAuthorizationToken.REALM.getName()).append("=\"").append(REALM_NAME).append("\",");
  sb.append(DigestAuthorizationToken.NONCE.getName()).append("=\"").append(nonce).append("\",");
  sb.append(DigestAuthorizationToken.DIGEST_URI.getName()).append("=\"/\",");
  sb.append(DigestAuthorizationToken.RESPONSE.getName()).append("=\"").append(response).append("\"");
  get.addHeader(AUTHORIZATION.toString(),sb.toString());
  result=client.execute(get);
  assertEquals(401,result.getStatusLine().getStatusCode());
  assertSingleNotificationType(EventType.FAILED_AUTHENTICATION);
}
