# dof
Explain and Demo about Design Patterns

# Multiple SSH Keys settings for different github account
=================================================================


create different public key
---------------------------------

create different ssh key according the article [Mac Set-Up Git](http://help.github.com/mac-set-up-git/)

	$ ssh-keygen -t rsa -C "your_email@youremail.com"

Please refer to [github ssh issues](http://help.github.com/ssh-issues/) for common problems.

for example, 2 keys created at:

	~/.ssh/id_rsa_mac
	~/.ssh/id_rsa_windows

then, add these two keys as following

	$ ssh-add ~/.ssh/id_rsa_mac
	$ ssh-add ~/.ssh/id_rsa_windows

you can delete all cached keys before

	$ ssh-add -D

finally, you can check your saved keys

	$ ssh-add -l


Modify the ssh config
---------------------------------

	$ cd ~/.ssh/
	$ touch config
	$ subl -a config

Then added

	#mac account
	Host github.com-mac
		HostName github.com
		User git
		IdentityFile ~/.ssh/id_rsa_mac

	#windows account
	Host github.com-windows
		HostName github.com
		User git
		IdentityFile ~/.ssh/id_rsa_windows


Clone you repo and modify your Git config
---------------------------------------------

clone your repo
	git clone git@github.com:iamlamnguyen/dof.git dof

cd dof and modify git config

	$ git config user.name "mac"
	$ git config user.email "iamlamnguyen@gmail.com" 
 
	$ git config user.name "windows"
	$ git config user.email "iamlamnguyen@gmail.com" 

or you can have global git config
	$ git config --global user.name "iamlamnguyen"
	$ git config --global user.email "iamlamnguyen@gmail.com"


then use normal flow to push your code

	$ git add .
	$ git commit -m "your comments"
	$ git push
