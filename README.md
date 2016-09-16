# AWS IoT Button for when you fuck up

When you inevitably fuck up at work this little hack will be handy.

It hooks up an AWS IoT Button to check who is currently on call and 
sends a postmate to fetch them flowers (or anything else you specify).

# Setup
Generate a PagerDuty API key
https://support.pagerduty.com/hc/en-us/articles/202829310-Generating-an-API-Key

Pick an escalation policy that the button will pick the on call user from. Click on it, save the id from the url.

https://sorrybutton.pagerduty.com/escalation_policies

Generate a Postmates API key
https://postmates.com/developer

Buy and set up a button
https://aws.amazon.com/iot/button/

Copy the config template

    cp src/config/sorrybutton.yaml.template src/config/sorrybutton.yaml

Fill it out with the keys from above, the address of the pickup location and dropoff location.

Build the package

    mvn package
    
Upload the result to Amazon Lambda https://aws.amazon.com/lambda/
Set up the button to execute the Lambda as per the Amazon instructions.
The handler is nu.oskarsson.sorrybutton.ButtonRequestHandler