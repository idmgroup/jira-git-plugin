jira-git-plugin
===============

A git plugin for Jira for smaller repos.  An alternative to fisheye and stash.

My fork tracks branch re-writes and has an alternative commit view which collects the branches.  


Known Issues:
=============

At this time the modified files do not properly reference gitweb (known issue)

Historical:
===========

I originally copied the atlassian SVN plugin to create the early jira-git plugin which ran against Jira 3.13.  It was my first atlassian plugin AND I was learning git at the same time.  Unfortunately my work did not upgrade to Jira 4.0 until 3 years later.  During this time, Ivan Sungurov cared for the code, then mteodori, and then I forked danielcsgomes (hooray for open source!).  I also noticed there was a commercial offering of "my"/"our" code - welcome to the BSD license!  

I might have been happy to pay for it but it wasn't clear whether it solved the problem I had - which was branch re-writes break the code.  So I delved in with a higher knowledge of git than in the past and the change was quite trivial.  Similarly I added the ability to collect the branches in the UI (e.g. git branch --contains equivalent) for each patch.  So easy!
