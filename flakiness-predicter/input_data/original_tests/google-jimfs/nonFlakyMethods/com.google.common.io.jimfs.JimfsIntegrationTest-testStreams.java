@Test public void testStreams() throws IOException {
  try (OutputStream out=Files.newOutputStream(path("/test"))){
    for (int i=0; i < 100; i++) {
      out.write(i);
    }
  }
   byte[] expected=new byte[100];
  for (byte i=0; i < 100; i++) {
    expected[i]=i;
  }
  try (InputStream in=Files.newInputStream(path("/test"))){
    byte[] bytes=new byte[100];
    ByteStreams.readFully(in,bytes);
    assertArrayEquals(expected,bytes);
  }
   try (Writer writer=Files.newBufferedWriter(path("/test.txt"),UTF_8)){
    writer.write("hello");
  }
   try (Reader reader=Files.newBufferedReader(path("/test.txt"),UTF_8)){
    assertEquals("hello",CharStreams.toString(reader));
  }
   try (Writer writer=Files.newBufferedWriter(path("/test.txt"),UTF_8,APPEND)){
    writer.write(" world");
  }
   try (Reader reader=Files.newBufferedReader(path("/test.txt"),UTF_8)){
    assertEquals("hello world",CharStreams.toString(reader));
  }
 }
