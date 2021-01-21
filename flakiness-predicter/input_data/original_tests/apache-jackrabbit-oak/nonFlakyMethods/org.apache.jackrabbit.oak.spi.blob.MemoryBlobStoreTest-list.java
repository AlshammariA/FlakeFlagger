@Test public void list() throws Exception {
  Set<String> ids=createArtifacts();
  Iterator<String> iter=store.getAllChunkIds(0);
  while (iter.hasNext()) {
    ids.remove(iter.next());
  }
  assertTrue(ids.isEmpty());
}
