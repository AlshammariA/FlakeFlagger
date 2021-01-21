/** 
 * Test for a successful authentication.
 */
@Test public void testDigestSuccess() throws Exception {
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
  assertFalse(parsedHeader.containsKey(DigestWWWAuthenticateToken.MESSAGE_QOP));
  String nonce=parsedHeader.get(DigestWWWAuthenticateToken.NONCE);
  String response=createResponse("userOne",REALM_NAME,"passwordOne","GET","/",nonce);
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
  assertEquals(200,result.getStatusLine().getStatusCode());
  values=result.getHeaders("ProcessedBy");
  assertEquals(1,values.length);
  assertEquals("ResponseHandler",values[0].getValue());
  values=result.getHeaders("Authentication-Info");
  assertEquals(1,values.length);
  Map<AuthenticationInfoToken,String> parsedAuthInfo=AuthenticationInfoToken.parseHeader(values[0].getValue());
  nonce=parsedAuthInfo.get(AuthenticationInfoToken.NEXT_NONCE);
  response=createResponse("userOne",REALM_NAME,"passwordOne","GET","/",nonce);
  assertSingleNotificationType(EventType.AUTHENTICATED);
  client=new TestHttpClient();
  get=new HttpGet(DefaultServer.getDefaultServerURL());
  sb=new StringBuilder(DIGEST.toString());
  sb.append(" ");
  sb.append(DigestAuthorizationToken.USERNAME.getName()).append("=").append("\"userOne\"").append(",");
  sb.append(DigestAuthorizationToken.REALM.getName()).append("=\"").append(REALM_NAME).append("\",");
  sb.append(DigestAuthorizationToken.NONCE.getName()).append("=\"").append(nonce).append("\",");
  sb.append(DigestAuthorizationToken.DIGEST_URI.getName()).append("=\"/\",");
  sb.append(DigestAuthorizationToken.RESPONSE.getName()).append("=\"").append(response).append("\"");
  get.addHeader(AUTHORIZATION.toString(),sb.toString());
  result=client.execute(get);
  assertEquals(200,result.getStatusLine().getStatusCode());
  values=result.getHeaders("ProcessedBy");
  assertEquals(1,values.length);
  assertEquals("ResponseHandler",values[0].getValue());
  assertSingleNotificationType(EventType.AUTHENTICATED);
}
