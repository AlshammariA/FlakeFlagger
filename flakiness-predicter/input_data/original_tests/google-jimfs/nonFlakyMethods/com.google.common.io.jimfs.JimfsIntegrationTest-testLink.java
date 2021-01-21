@Test public void testLink() throws IOException {
  Files.createFile(path("/file.txt"));
  assertThat("/file.txt").hasLinkCount(1);
  Files.createLink(path("/link.txt"),path("/file.txt"));
  assertThat("/link.txt").isSameFileAs("/file.txt");
  assertThat("/file.txt").hasLinkCount(2);
  assertThat("/link.txt").hasLinkCount(2);
  assertThat("/file.txt").containsNoBytes();
  assertThat("/link.txt").containsNoBytes();
  byte[] bytes={0,1,2,3};
  Files.write(path("/file.txt"),bytes);
  assertThat("/file.txt").containsBytes(bytes);
  assertThat("/link.txt").containsBytes(bytes);
  Files.write(path("/link.txt"),bytes,APPEND);
  assertThat("/file.txt").containsBytes(0,1,2,3,0,1,2,3);
  assertThat("/link.txt").containsBytes(0,1,2,3,0,1,2,3);
  Files.delete(path("/file.txt"));
  assertThat("/link.txt").hasLinkCount(1);
  assertThat("/link.txt").containsBytes(0,1,2,3,0,1,2,3);
}
