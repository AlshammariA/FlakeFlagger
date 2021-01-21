@Test public void testRearrangeOldData() throws IOException {
  new FileOutputStream(new File(directory,"data00000.tar")).close();
  new FileOutputStream(new File(directory,"data00010a.tar")).close();
  new FileOutputStream(new File(directory,"data00030.tar")).close();
  new FileOutputStream(new File(directory,"bulk00002.tar")).close();
  new FileOutputStream(new File(directory,"bulk00005a.tar")).close();
  Map<Integer,?> files=FileStore.collectFiles(directory);
  assertEquals(newArrayList(0,1,31,32,33),newArrayList(newTreeSet(files.keySet())));
  assertTrue(new File(directory,"data00000a.tar").isFile());
  assertTrue(new File(directory,"data00001a.tar").isFile());
  assertTrue(new File(directory,"data00031a.tar").isFile());
  assertTrue(new File(directory,"data00032a.tar").isFile());
  assertTrue(new File(directory,"data00033a.tar").isFile());
  files=FileStore.collectFiles(directory);
  assertEquals(newArrayList(0,1,31,32,33),newArrayList(newTreeSet(files.keySet())));
}
