# AWS IoT Button for when you fuck up

When you inevitably fuck up at work this little hack will be handy.

It hooks up an AWS IoT Button to check who is currently on call and 
sends a postmate to fetch them flowers (or anything else you specify).

# Setup
Generate an API key
https://support.pagerduty.com/hc/en-us/articles/202829310-Generating-an-API-Key

Pick an escalation policy that the button will pick the on call user from. Click on it, copy the id from the url
to the configuration file.

https://sorrybutton.pagerduty.com/escalation_policies

Copy the config template
cp src/config/sorrybutton.yaml.template src/config/sorrybutton.yaml

Fill it out with the keys from above, the address of the pickup location and dropoff location.