Hi.

Thanks for taking the time to look into this for me. I really appreciate it.
I initially had AccountId and TenantId rather than x-account-id and x-tenant-id on my header.
This is because on the task file sent to me, it was written as AccountId and TenantId.

I have now made the changes to x-account-id and x-tenant-id and I am still getting the
403 Forbidden.

I was hoping the changes would work and I wouldn't have to bother you with this.

Also, you are right that there is no body on the request. However, what I'm trying to do
is create the order ref separately first then use it on the instructions request

From the website
Description
Create a new Order.

If you create the Order without any instructions then the response will be 201 - Created.
If you create the Order with instructions then the response will be 202 - Accepted

and this is the post /v1/order-management

Regards

Deen





