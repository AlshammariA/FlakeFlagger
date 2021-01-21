@Test public void commitRoot(){
  DocumentMK mk=createMK();
  try {
    DocumentStore store=mk.getDocumentStore();
    Revision head=Revision.fromString(mk.getHeadRevision());
    head=Revision.fromString(mk.commit("","+\"/test\":{\"foo\":{}}",head.toString(),null));
    NodeDocument rootDoc=store.find(Collection.NODES,"0:/");
    NodeDocument node=store.find(Collection.NODES,"1:/test");
    NodeDocument foo=store.find(Collection.NODES,"2:/test/foo");
    assertNotNull(foo);
    assertFalse(foo.containsRevision(head));
    assertEquals("/",foo.getCommitRootPath(head));
    head=Revision.fromString(mk.commit("","+\"/bar\":{}+\"/test/foo/bar\":{}",head.toString(),null));
    rootDoc=store.find(Collection.NODES,"0:/");
    assertNotNull(rootDoc);
    assertTrue(rootDoc.containsRevision(head));
    NodeDocument bar=store.find(Collection.NODES,"1:/bar");
    assertNotNull(bar);
    assertEquals("/",bar.getCommitRootPath(head));
    bar=store.find(Collection.NODES,"3:/test/foo/bar");
    assertNotNull(bar);
    assertEquals("/",bar.getCommitRootPath(head));
  }
  finally {
    mk.dispose();
  }
}
