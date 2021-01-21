@Test public void testOfferEventSequenceAndRun() throws Exception {
  for (int i=0; i < 10; i++) {
    client.offer(TEST_EVENT + i);
  }
  Thread thread=new Thread(client);
  thread.start();
  thread.join(1000);
  assertFalse(thread.isAlive());
  ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
  for (int i=0; i < 10; i++) {
    assertEquals(TEST_EVENT + i,ois.readObject());
  }
}
