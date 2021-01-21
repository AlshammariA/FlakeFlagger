private void retryPersisted(boolean useMK) throws Exception {
  MemoryDocumentStore ds=new MemoryDocumentStore();
  MemoryBlobStore bs=new MemoryBlobStore();
  DocumentMK mk1=createMK(1,1000,ds,bs);
  DocumentMK mk2=createMK(2,1000,ds,bs);
  try {
    NodeStore ns1;
    NodeStore ns2;
    if (useMK) {
      ns1=new KernelNodeStore(mk1);
      ns2=new KernelNodeStore(mk2);
    }
 else {
      ns1=mk1.getNodeStore();
      ns2=mk2.getNodeStore();
    }
    NodeBuilder builder1=ns1.getRoot().builder();
    createTree(builder1.child("bar"),2);
    NodeBuilder builder2=ns2.getRoot().builder();
    createTree(builder2.child("qux"),2);
    ns1.merge(builder1,HOOK,CommitInfo.EMPTY);
    ns2.merge(builder2,HOOK,CommitInfo.EMPTY);
  }
  finally {
    mk1.dispose();
    mk2.dispose();
  }
}
