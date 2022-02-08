


    #!/bin/bash
    # Autocommit by Gabriel Small
git add *.java
echo what is your commit note?
read commitnotes
git commit -m "$commitnotes"
git push
