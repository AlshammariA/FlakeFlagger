/** 
 * Make this test method to follow a flow which throws IOException
 */
@Test(expected=IOException.class) public void testInvalidUrl() throws Exception {
  victim.locate("/invalid/resource.css");
}
