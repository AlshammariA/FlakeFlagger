@Test public void testParsingSetCookieHeaderV1(){
  Cookie cookie=Cookies.parseSetCookieHeader("Customer=\"WILE_E_COYOTE\"; Version=\"1\"; Path=\"/acme\"");
  Assert.assertEquals("Customer",cookie.getName());
  Assert.assertEquals("WILE_E_COYOTE",cookie.getValue());
  Assert.assertEquals("/acme",cookie.getPath());
  Assert.assertEquals(1,cookie.getVersion());
  cookie=Cookies.parseSetCookieHeader("SHIPPING=\"FEDEX\"; path=\"/foo\"; secure; Version=\"1\";");
  Assert.assertEquals("SHIPPING",cookie.getName());
  Assert.assertEquals("FEDEX",cookie.getValue());
  Assert.assertEquals("/foo",cookie.getPath());
  Assert.assertTrue(cookie.isSecure());
  Assert.assertEquals(1,cookie.getVersion());
}
