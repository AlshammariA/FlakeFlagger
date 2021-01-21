/** 
 * Test for several mangled header examples based on  {@link http ://developer.yahoo.com/blogs/ydn/posts/2010/12/pushing-beyond-gzipping/} blog post.
 */
@Test public void testGzipSupport() throws Exception {
  HttpServletRequest request=mockRequestHeader("","");
  assertFalse(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("Accept-Encoding","");
  assertFalse(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("Accept-Encoding","gzip, deflate");
  assertTrue(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("Accept-Encoding","XYZ");
  assertFalse(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("Accept-EncodXng","XXXXXXXXXXXXX");
  assertTrue(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("X-cept-Encoding","gzip,deflate");
  assertTrue(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("XXXXXXXXXXXXXXX","XXXXXXXXXXXXX");
  assertTrue(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("XXXXXXXXXXXXXXXX","gzip, deflate");
  assertFalse(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("---------------","-------------");
  assertTrue(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("~~~~~~~~~~~~~~~","~~~~~~~~~~~~~");
  assertTrue(WroUtil.isGzipSupported(request));
  request=mockRequestHeader("Accept-Encoding","gzip,deflate,sdch");
  assertTrue(WroUtil.isGzipSupported(request));
}
