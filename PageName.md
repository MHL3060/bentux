# Add data into the db when build #

here is the procedure how to add data into the db when build

1). in your app. enter whatever the data you want to enter.
2). in terminal, under your project directory, run mvn dbunit:export. A file is generated and placed in target/dbunit

3). copy the data and placed it inside the sample-data.xml

4). run build again. the data should in the db's table


# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages