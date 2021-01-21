@Test public void addBlobs() throws Exception {
  DocumentMK mk=new DocumentMK.Builder().setMongoDB(openMongoConnection()).open();
  long blobSize=TOTAL_SIZE / DOCUMENT_COUNT;
  ArrayList<String> blobIds=new ArrayList<String>();
  Random r=new Random();
  for (int i=0; i < DOCUMENT_COUNT; i++) {
    log("writing " + i + "/"+ DOCUMENT_COUNT);
    String id=mk.write(new RandomStream(blobSize,r.nextInt()));
    blobIds.add(id);
  }
  for (  String id : blobIds) {
    assertEquals(blobSize,mk.getLength(id));
  }
  mk.dispose();
}
