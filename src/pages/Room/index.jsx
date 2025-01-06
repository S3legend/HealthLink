import React from 'react';
import {useParams} from 'react-router-dom';
import {ZegoUIKitPrebuilt} from "@zegocloud/zego-uikit-prebuilt";
import "../../Navbar.css"
import Navbar from '../../components/Navbar'

const RoomPage = () => {
        const { roomId } = useParams();

        const myMeeting = async (element) => {
                const appID = 579153797;
                const serverSecret = "2b0da3c0dd9184243ac62c74dce2be0b";
                const kitToken = ZegoUIKitPrebuilt.generateKitTokenForTest(
                    appID,
                    serverSecret,
                    roomId,
                    Date.now().toString(),
                    "consultation"
                );
                const zc = ZegoUIKitPrebuilt.create(kitToken);
                zc.joinRoom({
                        container: element,
                        sharedLinks: [
                                {
                                        name: 'Copy Link',
                                        url: `http://localhost:3000/room/${roomId}`,
                                }
                        ],
                        scenario: {
                                mode: ZegoUIKitPrebuilt.OneONoneCall,
                        },
                        showScreenSharingButton: false,
                });
        };

        return (
            <div>
                    <Navbar /> {/* Inclure le composant Navbar */}
                    <div className="content"> {/* Ajoutez une classe pour le contenu principal */}
                            <div ref={myMeeting} />
                    </div>
            </div>
        );
};

export default RoomPage;