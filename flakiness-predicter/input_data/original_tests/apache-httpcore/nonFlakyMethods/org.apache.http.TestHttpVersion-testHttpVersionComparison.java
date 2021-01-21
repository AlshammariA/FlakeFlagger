@Test public void testHttpVersionComparison(){
  Assert.assertTrue(HttpVersion.HTTP_0_9.lessEquals(HttpVersion.HTTP_1_1));
  Assert.assertTrue(HttpVersion.HTTP_0_9.greaterEquals(HttpVersion.HTTP_0_9));
  Assert.assertFalse(HttpVersion.HTTP_0_9.greaterEquals(HttpVersion.HTTP_1_0));
  Assert.assertTrue(HttpVersion.HTTP_1_0.compareToVersion(HttpVersion.HTTP_1_1) < 0);
  Assert.assertTrue(HttpVersion.HTTP_1_0.compareToVersion(HttpVersion.HTTP_0_9) > 0);
  Assert.assertTrue(HttpVersion.HTTP_1_0.compareToVersion(HttpVersion.HTTP_1_0) == 0);
}
