@Test public void testGetItem() throws Exception {
  Item item=superuser.getItem(n.getPath());
  if (item.isNode()) {
    assertTrue(n.isSame(item));
  }
 else {
    assertTrue(p.isSame(item));
  }
}
