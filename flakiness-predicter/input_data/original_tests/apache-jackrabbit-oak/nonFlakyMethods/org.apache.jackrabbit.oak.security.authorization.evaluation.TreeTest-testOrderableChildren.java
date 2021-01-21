/** 
 * @see <a href="https://issues.apache.org/jira/browse/OAK-842">OAK-842</a>
 */
@Test public void testOrderableChildren() throws Exception {
  Tree a=root.getTree("/a");
  a.setOrderableChildren(true);
  testRoot.refresh();
  for (  Tree t : testRoot.getTree("/a").getChildren()) {
    if (!"b".equals(t.getName())) {
      fail("Child " + t.getName() + " should not be accessible.");
    }
  }
}
