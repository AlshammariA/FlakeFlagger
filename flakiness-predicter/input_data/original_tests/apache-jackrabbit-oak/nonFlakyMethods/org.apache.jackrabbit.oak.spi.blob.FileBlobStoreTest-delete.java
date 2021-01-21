@Test public void delete() throws Exception {
  Set<String> ids=createArtifacts();
  store.deleteChunks(Lists.newArrayList(ids),0);
  Iterator<String> iter=store.getAllChunkIds(0);
  Set<String> ret=Sets.newHashSet();
  while (iter.hasNext()) {
    ret.add(iter.next());
  }
  assertTrue(ret.toString(),ret.isEmpty());
}
